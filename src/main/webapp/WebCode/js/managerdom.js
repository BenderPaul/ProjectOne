
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
		const acptButton = document.createElement("td");
		const denyButton = document.createElement("td");

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
			if (reimb.reimbursementTypeId === 3){
				type = "Pay Advance"
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
		acptButton.innerHTML = '<td><form method="POST" action="/Project1/approve.json"><input type="hidden" value="reimb.reimbursementId" id="acceptReimbursementId"/><button type="submit" class="btn btn-outline-success"></button></form></td>';
		denyButton.innerHTML = '<td><form method="POST" action="/Project1/deny.json"><input type="hidden" value="reimbursementId" id="denyReimbursementId"/><button type="submit" class="btn btn-outline-danger"></button></form></td>';

		tr.append(IDTd);
		tr.append(amountTd);
		tr.append(subDateTd);
		tr.append(resolvedateTd);
		tr.append(descriptionTd);
		tr.append(authorTd);
		tr.append(resolverTd);
		tr.append(statusTd);
		tr.append(typeTd);
		tr.append(acptButton);
		tr.append(denyButton);

		document.getElementById("reimbTableBody").append(tr);
		document.getElementById("acceptReimbursementId").value = reimb.reimbursementId;
		document.getElementById("denyReimbursementId").value = reimb.reimbursementId;
	}
}

//renderTable(fetch('http://localhost:8080/Project1/all.json'));

//document.getElementById("claimSubmit").addEventListener('click', addReimbursement);

 fetch('http://52.42.213.40:8082/Project1/openreimbs.json', {
  	body: JSON.stringify(),
  	method: 'post',
 	mode: "no-cors",

  })
  .then((r)=>r.json()).then((reimbursements) => renderTable(reimbursements));



