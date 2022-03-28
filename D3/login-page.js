const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const username = loginForm.username.value;
    const password = loginForm.password.value;
    apiResponse = false;

    // if (username === "user" && password === "web_dev") {
    //     alert("You have successfully logged in.");
    //     location.reload();
    // } else {
    //     loginErrorMsg.style.opacity = 1;
    // }


    // const userAction = async () => {
    //     const response = await fetch('http://localhost:9090/ctf/createUser/samika/EnCryPtF%40ce', {
    //       method: 'POST',
    //       body: myBody, // string or object
    //       headers: {
    //         'Content-Type': 'application/json'
    //       }
    //     });
    //     const myJson = await response.json(); //extract JSON from the http response
    //     // do something with myJson
    //   }


    // const userAction = async () => {
    //     const response = await fetch('http://localhost:9090/ctf/getAllConfigs', {
    //       method: 'GET',
    //       headers: {
    //         'Content-Type': 'application/json'
    //       }
    //     });
    //     const myJson = await response.json(); 
    //     console.log("successful");
    //   }

    // const url = "http://localhost:9090/ctf/createUser/";
    // url = url + username + "/" + password;
    const url = `http://localhost:9090/ctf/createUser/${username}/${password}`;
    fetch(
        url,
        {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        }
    ).then(response=>response.json())
    .then(data=>{ 
        console.log(data); 
        apiResponse = data;
        if(apiResponse == true){
            alert('User Created Successfully');
        }
        else {
            alert('Invalid operation, user might already exist!')
        }
    })
})