const API = "http://localhost:8080";
document.addEventListener("DOMContentLoaded", () => {
  if (!localStorage.getItem("userId")) window.location = "index.html";
  showSection("catalog"); loadProfile(); search();
});
function logout() {
  localStorage.clear();
  window.location = "index.html";
}
function showSection(id) {
  document.querySelectorAll("main section")
    .forEach(s => s.classList.toggle("hidden", s.id!==id));
  if (id==="myOrders") loadOrders();
}
function loadProfile() {
  document.getElementById("profId").textContent = localStorage.getItem("userId");
  document.getElementById("profRole").textContent = localStorage.getItem("userRole");
  document.getElementById("profName").textContent = localStorage.getItem("userName") || "—";
}

function search() {
  const t = document.getElementById("typeSearch").value;
  const w = document.getElementById("weightSearch").value;
  const url = `${API}/catalog?${t?'type='+t+'&':''}${w?'weight='+w:''}`;

  fetch(url)
    .then(res => res.json())
    .then(data => {
      document.getElementById("catTbl").innerHTML = data.map(p => `
        <tr><td>${p.jewelName}</td><td>${p.jewelType}</td><td>${p.pricePerGram}</td><td>${p.weight}</td>
        <td><button onclick="book(${p.id})">Book</button></td></tr>`
      ).join("");
    });
}

function book(pid) {
  const uid = localStorage.getItem("userId");
  fetch(`${API}/bookings/book/${pid}/user/${uid}`, { method:"POST" })
    .then(res => res.json())
    .then(b => {
      const card = prompt("Enter 16‑digit card number");
      return fetch(`${API}/bookings/pay/${b.id}`, {
        method:"POST",
        headers:{'Content-Type':'application/json'},
        body: JSON.stringify({ cardNumber: card })
      });
    })
    .then(res => res.text())
    .then(msg => {
      alert("Payment confirmed: " + msg);
      loadOrders();
    });
}

function loadOrders() {
  fetch(`${API}/customers/${localStorage.getItem("userId")}/purchases`)
    .then(res => res.json())
    .then(list => {
      document.getElementById("ordersList").innerHTML = list
        .map(o => `<li>ID: ${o.bookingId}, Email: ${o.userEmail}, Phone: ${o.userPhone}</li>`)
        .join("");
    });
}