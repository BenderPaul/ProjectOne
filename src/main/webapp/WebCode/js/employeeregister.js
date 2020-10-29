
function renderTable(reimbursements) {
	for (const reimb of reimbursements) {
		const tr = document.createElement("tr");
		const IDTd = document.createElement("td");
		const amountTd = document.createElement("td");
		const subDateTd = document.createElement("td");
		const resolvedateTd = document.createElement("td");
		const descriptionTd = document.createElement("td");
		const authorTd = document.createElement("td");
		const resolverTd = document.createElement("td");
		const statusTd = document.createElement("td");
		const typeTd = document.createElement("td");

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

//renderTable(fetch('http://localhost:8080/Project1/all.json'));

//document.getElementById("claimSubmit").addEventListener('click', addReimbursement);

 fetch('http://52.42.213.40:8082/Project1/all.json', {
  	body: JSON.stringify(),
  	method: 'post',
 	mode: "no-cors",
 	headers:{
 		origin: 'localhost'
 	} 
  })
  .then((r)=>r.json())
  .then((reimbursements) => renderTable(reimbursements));