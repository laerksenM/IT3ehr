async function opretNyKonsultation(){
    let result = await fetch("rest/konsultationer");

    console.log(result.status)
    if (result.status!=200){
        alert("noget gik galt!");
    }
    let json = await result.json();
    console.log(json)
    // Ovenstående kode ikke færdig!
}
