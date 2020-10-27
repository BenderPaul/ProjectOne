
// const reimbursements = [
// 	{
// 		amount: "5000",
// 		status: "approved",
// 		submitDate: "2020",
// 		type: "purchase",
// 		description: "hot dogs"
// 	},
// ]
function renderTable(reimbursements) {
	for (const reimb of reimbursements) {
		const tr = document.createElement("tr");
		const IDTd = document.createElement("td");
		const amountTd = document.createElement("td");
		const subDateTd = document.createElement("td");
		const resolvedateTd = document.createElement("td");
		const descriptionTd = document.createElement("tr");
		const authorTd = document.createElement("td");
		const resolverTd = document.createElement("td");
		const statusTd = document.createElement("td");
		const typeTd = document.createElement("tr");

		IDTd.innerText = reimb.reimbursementId;
		amountTd.innerText = reimb.reimbursementAmount;
		subDateTd.innerText = reimb.submittedDate;
		resolvedateTd.innerText = reimb.resolvedDate;
		descriptionTd.innerText = reimb.description;
		authorTd.innerText = reimb.reimbursementAuthor;
		resolverTd.innerText = reimb.reimbursementResolver;
		statusTd.innerText = reimb.reimbursementStatusId;
		typeTd.innerText = reimb.reimbursementTypeId;

		tr.append(IDTd);
		tr.append(amountTd);
		tr.append(subDateTd);
		tr.append(resolvedateTd);
		tr.append(descriptionTd);
		tr.append(authorTd);
		tr.append(resolverTd);
		tr.append(statusTd);
		tr.append(typeTd);

		document.getElementById("reimbTableBody").append(tr);
	}
}


//async fetch("http://localhost:8080/Project1/all.json", renderTable());

// function addReimbursement(){
//  	console.log(document.getElementById(""))
//  }
 function addReimbursement(){
 	const reimbursement = {
		reimbursementId: 100,
		reimbursementAmount: document.getElementById("reimb_amount"),
		submittedDate: document.getElementById("reimb_submitted"),
		resolvedDate: '2000-10-10',
		description: document.getElementById("reimb_description"),
		reimbursementAuthor: 1,
		reimbursementResolver: 1,
		reimbursementStatusId: 1,
		reimbursementTypeId: document.getElementById("reimb_type_id") 
	 }
	fetch('http://localhost:8080/Project1/reimb.json',{
		 body: JSON.stringify(reimbursement),
		 method: 'post',
		 mode: "no-cors",
		 headers:{
			 origin: 'localhost'
		 }
	}) 
}

//document.getElementById("claimSubmit").onclick = addReimbursement();


//renderTable(fetch('http://localhost:8080/Project1/all.json'));

//document.getElementById("claimSubmit").addEventListener('click', addReimbursement);

 fetch('http://localhost:8080/Project1/all.json', {
  	body: JSON.stringify(),
  	method: 'post',
 	mode: "no-cors",
 	headers:{
 		origin: 'localhost'
 	} 
  })
  .then((r)=>r.json())
  .then((reimbursements) => renderTable(reimbursements));