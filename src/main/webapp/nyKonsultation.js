async function opretNyKonsultation() {
    let form = document.getElementById("konsultationForm");
    let formKonsul = new FormData(form);
    let aftaleJson = Object.fromEntries(formKonsul)
    console.log(aftaleJson);
    let res = await fetch("rest/opretKonsultation", {
            method: "POST",
            body: JSON.stringify(aftaleJson),
            headers: {
                "content-type": "application/json",
                "authorization": localStorage.getItem("token") //vi getter authoration fra hvor vores token er gemt
            }
        }
    );
    console.log("Heeeeej")
    console.log(res.body);
    console.log(res.status)
    if (res.status != 200) {
        alert("noget gik galt: " + res.status)

    } else {
        console.log(res.status)
        console.log(res.status + "det lykkedes");
        window.location.href = "kalender.html"
    }

    let json = await res.json();
    console.log(json)

// Ovenstående kode ikke færdig!
}
