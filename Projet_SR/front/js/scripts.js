
url1='http://localhost:3000'
url2='http://localhost:8080/api/v1/citoyen'

fetch(`${url}/${cin}`)
.then(res => { return res.json() ; }).then((json => { console.log(json) ; }));

async function getUserInt(cin) {
    try {
        let res = await fetch(`${url2}/${cin}`);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
}

async function getUserFin(cin) {
    try {
        let res = await fetch(`${url1}/${cin}`);
        return await res.json();
    } catch (error) {
        console.log(error);
    }
}
// document.getElementById("submitButton").addEventListener("click", renderUser);
async function renderUser() {
    var cin = document.getElementById("cin").value;
    console.log(cin) ;
    console.log("yes");
    let user = await getUserInt(cin);
    let userFin = await getUserFin(cin);
    console.log(user);
    let html = '';

        let htmlSegment = `<div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-5">
                        <h2>Les <b> infractions cherchées</b></h2>
                    </div>
                    <div class="col-sm-7">
                   
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Nom et prénom</th>						
                        <th>CIN</th>
                        <th>Adresse</th>
                        <th>Matricule</th>
                        <th>Permis</th>
                        <th>Avis de recherche</th>
                        <th>Infractions finance</th>
                        <th>Infractions Intérieur </th>

                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${user.firstName} ${user.lastName}</td>
                        <td>${user.id}</td>                        
                        <td>${user.adresse}</td>
                        <td>${user.matricule}</td>
                        <td>${user.codepermis}</td>
                        <td>${userFin.recherche}</td>
                        <td> ${userFin.infractions}</td>
                        <td> ${user.infractions}</td>
                    </tr>
                </tbody>
              </table>
        
            </div>
            </div>`;

        html += htmlSegment;
/* 
    let container = document.querySelector('.container-xl');
    container.innerHTML = html; */
    document.getElementById("id").innerHTML = html;
}