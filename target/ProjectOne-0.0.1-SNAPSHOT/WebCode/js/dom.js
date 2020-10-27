





const mockedReimb = [
	{
		amount: "5000",
		status: "approved",
		submitDate: "2020",
		type: "purchase",
		description: "hot dogs"
	},
]
for (const reimb of mockedReimb) {
	const tr = document.createElement("tr");
	const amountTd = document.createElement("td");
	const statusTd = document.createElement("td");
	const submitDateTd = document.createElement("td");
	const typeTd = document.createElement("td");
	const descriptionTd = document.createElement("td");

	amountTd.innerText = reimb.amount;
	statusTd.innerText = reimb.status;
	submitDateTd.innerText = reimb.submitDate;
	typeTd.innerText = reimb.type;
	descriptionTd.innerText = reimb.description;
	tr.append(amountTd);
	tr.append(statusTd);
	tr.append(submitDateTd);
	tr.append(typeTd);
	tr.append(descriptionTd);

	document.getElementById("reimbTableBody").append(tr);
}
