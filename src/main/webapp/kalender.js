async function hentPatienter(){
    let result = await fetch("rest/patients",{
        method:"GET", // husk brug Get da vi skal hente her.
        headers:{
            "content-type": "application/json",
            "authorization": localStorage.getItem("token")
        }
    })
    data = await result.json()
   /* console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json);

    */
    // Vis patienter
    window.location.href= "nyKonsultation.html"
}

//TODO: sende tokenen med og validere den