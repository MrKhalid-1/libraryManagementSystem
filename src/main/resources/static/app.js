document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Send POST request to your backend API for authentication
    fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            username: username,
            password: password,
        })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            // Store the token or session if successful
            localStorage.setItem('auth-token', data.token);
            document.getElementById('login-container').style.display = 'none';
            document.getElementById('user-info-container').style.display = 'block';
            document.getElementById('username-display').textContent = username;
        } else {
            alert('Invalid credentials!');
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
});

document.getElementById('logout').addEventListener('click', function() {
    localStorage.removeItem('auth-token');
    document.getElementById('login-container').style.display = 'block';
    document.getElementById('user-info-container').style.display = 'none';
});
