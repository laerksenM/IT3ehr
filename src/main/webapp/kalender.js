async function hentPatienter(){
    let result = await fetch("rest/api/patients",{
        method:"GET", // husk brug Get da vi skal hente her.
        headers:{
            "content-type": "application/json",
            "authorization": localStorage.getItem("token") //vi getter authoration fra hvor vores token er gemt
        }
    })
    if (result.status==401){ // hvis der opstår fejl
        alert("Du er ikke logget ind ellers har ikke rettigheder til at logge ind")
    }
    //data = await result.json()
   console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json);
    updatePatient(json)

}

function updatePatient(json) {
    console.log(json)
    let listelements =""
    json.forEach(function(e){
        listelements += ("<li>"+e.brugernavn + " "+e.password+"</li>")
    })
    let patientList = document.getElementById("patienter");
    patientList.innerHTML=listelements
}

async function hentKonsultationer() {
    let cpr = document.getElementById("konsultationsinput").value;
    let result = await fetch("rest/konsultationer?cpr_nummer=" + cpr, {
        method: "GET", // husk brug Get da vi skal hente her.
        headers: {
            "content-type": "application/json",
            "authorization": localStorage.getItem("token") //vi getter authoration fra hvor vores token er gemt
        }
    })
    if (result.status == 401) { // hvis der opstår fejl
        alert("Du er ikke logget ind ellers har ikke rettigheder til at logge ind")
    }

    // console.log("data modtaget: ", await result.json())
    const data = await result.json()

    alert("cpr nummer: " + data.cpr + "\ntime start: " +  data.timeStart + "\ntime end: " + data.timeEnd + "\nnotat: " + data.notat )
}