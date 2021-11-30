async function hentPatienter(){
    let result = await fetch("rest/patients",{
        method:"GET", // husk brug Get da vi skal hente her.
        headers:{
            "content-type": "application/json",
            "authorization": localStorage.getItem("token") //vi getter authoration fra hvor vores token er gemt
        }
    })
    if (result.status==401){ // hvis der opstår fejl
        alert("Du er ikke logget ind ellers har ikke rettigheder til at logge ind")
    }
    /* data = await result.json()
   console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }*/
    let json = await result.json();
    console.log(json);
    updatePatient(json);
    // Vis patienter
}

function updatePatient(json) {
    console.log(json)
    let listelements =""
    json.forEach(function(e){
        listelements += ("<li>"+e.brugernavn + " "+e.password+"</li>")
        //listelements += ("<li>"+e+"</li>")
    })
    //let patientList = document.getElementById("patient");
    let patientList = document.getElementById("patienter");
    patientList.innerHTML=listelements
}
