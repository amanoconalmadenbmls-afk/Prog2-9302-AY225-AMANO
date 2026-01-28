// Predefined login credentials
const correctUsername = "conamano";
const correctPassword = "12345";

// ✅ PUT THIS RIGHT HERE (TOP PART)
const beep = new Audio("beep.mp3");

// Attendance record storage
let loginRecord = {};

// Handle login form submit
document.getElementById("loginForm").addEventListener("submit", function(event) {

    event.preventDefault();

    const user = document.getElementById("username").value;
    const pass = document.getElementById("password").value;

    // Login validation
    if (user === correctUsername && pass === correctPassword) {

        document.getElementById("welcomeMsg").innerText = "Welcome, " + user + "!";

        const now = new Date();
        const timestamp = now.toLocaleString();
        document.getElementById("timestamp").innerText = "Login Time: " + timestamp;

        loginRecord.username = user;
        loginRecord.timestamp = timestamp;

        document.getElementById("downloadBtn").style.display = "inline";

    } else {

        // ❗ THIS IS WHERE THE BEEP SOUND IS PLAYED
        beep.play();
        alert("Incorrect username or password!");

    }
});
