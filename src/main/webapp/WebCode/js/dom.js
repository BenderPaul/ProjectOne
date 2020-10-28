
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

		let subd = new Date(reimb.submittedDate);
		let resd = new Date(reimb.resolvedDate);
		let stat;
		let type;
			if (reimb.reimbursementStatusId === 1){
				stat = "Submitted"
			}
			if (reimb.reimbursementStatusId === 2){
				stat = "Pending"
			}
			if (reimb.reimbursementStatusId === 3){
				stat = "Approved"
			}
			if (reimb.reimbursementStatusId === 4){
				stat = "Denied"
			}
			if (reimb.reimbursementTypeId === 1){
				type = "Purchase"
			}
			if (reimb.reimbursementTypeId === 2){
				type = "Robbery"
			}

		IDTd.innerText = reimb.reimbursementId;
		amountTd.innerText = reimb.reimbursementAmount;
		subDateTd.textContent = subd.toLocaleDateString();
		resolvedateTd.textContent = resd.toLocaleDateString();
		descriptionTd.innerText = reimb.description;
		authorTd.innerText = reimb.reimbursementAuthor;
		resolverTd.innerText = "2";
		statusTd.innerText = stat;
		typeTd.innerText = type;

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