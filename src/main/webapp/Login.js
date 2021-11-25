/*Så snart async tilføjes får denne sin egen tråd og kan køre */
async function login() {
    let loginForm = document.getElementById("loginform");
    let formData = new FormData(loginForm);
    let formObject = Object.fromEntries(formData);
    console.log(formObject);
    const res =await fetch("rest/login", {
        method: "POST",
        headers: {
            "content-type": "application/json"
        },
        body: JSON.stringify(formObject)
    })
    localStorage.setItem("token",await res.text()) // gemmer token

    window.location.href= "kalender.html"
}
/*
    }
    user = document.getElementById("Brugernavn").value;
    password = document.getElementById("password").value;
    console.log("user", user)
    console.log("password", password)
    const response = await fetch("http://localhost:8080/IT3final_war/rest/login?" + new URLSearchParams({
            Brugernavn: user,
            password: password,
        }
    ))

    console.log("hej")
    if (response.status >= 200 && response.status <= 299) {
        console.log("response: ", response)
        return response.text();
    } else {
        throw Error(await response.text());
    }

}*/
