async function CreatePatient(){
    let patientform = document.getElementById("patientform");
    let formData = new FormData(patientform);
    let patientJson = Object.fromEntries(formData);
    let res = await fetch("rest/patients", {
        method:"POST",
        body: JSON.stringify(patientJson),
        headers:{
            'content-type':"application/json",
            "authorization": localStorage.getItem("token")
        }
    })
    alert (res);
}

