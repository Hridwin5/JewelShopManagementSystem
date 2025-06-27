const API = "http://localhost:8080";
document.addEventListener("DOMContentLoaded", () => {
  if (localStorage.getItem("userRole") !== "ADMIN") window.location = "index.html";
  showSection("jewels"); loadJewels();
});

function logout() {
  localStorage.clear();
  window.location = "index.html";
}

function showSection(id) {
  document.querySelectorAll("main section")
    .forEach(s => s.classList.toggle("hidden", s.id!==id));
  if (id === "jewels") loadJewels();
  if (id === "customers") loadCustomers();
  if (id === "report") loadReport();
}

function loadJewels() {
  fetch(`${API}/products`)
    .then(res => res.json())
    .then(data => {
      document.getElementById("jewelTbl").innerHTML = data.map(j => `
        <tr>
          <td>${j.id}</td>
          <td>${j.jewelName}</td>
          <td>${j.pricePerGram}</td>
          <td>${j.jewelType}</td>
          <td>${j.weight}</td>
          <td><button onclick="editJewel(${j.id})">Edit</button><button onclick="delJewel(${j.id})">Del</button></td>
        </tr>`).join("");
    });
}

function saveJewel() {
  const id = document.getElementById("editJewelId").value;
  const payload = {
    jewelName: document.getElementById("jewelName").value,
    pricePerGram: +document.getElementById("pricePerGram").value,
    jewelType: document.getElementById("jewelType").value,
    weight: +document.getElementById("weight").value
  };
  const url = `${API}/products${id?'/'+id:''}`;
  fetch(url, {
    method: id ? "PUT" : "POST",
    headers: {'Content-Type':'application/json'},
    body: JSON.stringify(payload)
  }).then(() => {
    loadJewels();
    document.querySelector("form").reset();
  });
}

function editJewel(id) {
  fetch(`${API}/products`)
    .then(res => res.json())
    .then(data => {
      const j = data.find(x => x.id===id);
      document.getElementById("editJewelId").value = j.id;
      ["jewelName","pricePerGram","jewelType","weight"].forEach(f => document.getElementById(f).value = j[f]);
    });
}

function delJewel(id) {
  fetch(`${API}/products/${id}`, {method:"DELETE"})
    .then(() => loadJewels());
}

function loadCustomers() {
  fetch(`${API}/customers`)
    .then(res => res.json())
    .then(data => {
      document.getElementById("custTbl").innerHTML = data.map(c => `
        <tr><td>${c.id}</td><td>${c.userId}</td><td>${c.userEmail}</td><td>${c.userPhone}</td><td>${c.bookingId}</td></tr>
      `).join("");
    });
}

function loadReport() {
  fetch(`${API}/reports/sales`)
    .then(res => res.json())
    .then(r => {
      document.getElementById("reportData").innerHTML =
        `<p><strong>Total Sales:</strong> ₹${r.totalSales.toFixed(2)}</p>
         <p><strong>Bookings Count:</strong> ${r.bookingsCount}</p>`;
    });
}