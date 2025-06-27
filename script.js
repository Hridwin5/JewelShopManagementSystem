const API = "http://localhost:8080";

function login() {
  const email = document.getElementById("loginEmail").value;
  const password = document.getElementById("loginPassword").value;

  fetch(`${API}/auth/login`, {
    method: "POST",
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({ email, password })
  })
  .then(res => res.json())
  .then(user => {
    if (!user || !user.id) return alert("Invalid credentials");

    // Save to localStorage
    localStorage.setItem("userId", user.id);
    localStorage.setItem("userRole", user.role);
    localStorage.setItem("userName", user.name || "");

    // Redirect based on role
    if (user.role === "ADMIN") window.location = "admin.html";
    else if (user.role === "USER") window.location = "user.html";
    else alert("Unknown role: " + user.role);
  });
}

function register() {
  const name = document.getElementById("regName").value;
  const email = document.getElementById("regEmail").value;
  const password = document.getElementById("regPassword").value;
  const role = document.getElementById("regRole").value;

  if (!["USER", "ADMIN"].includes(role)) return alert("Invalid role");

  fetch(`${API}/auth/signup`, {
    method: "POST",
    headers: {'Content-Type': 'application/json'},
    body: JSON.stringify({ name, email, password, role })
  })
  .then(res => {
    if (res.ok) {
      alert(`Registered as ${role}. You may now log in.`);
    } else {
      alert("Registration failed");
    }
  });
}
