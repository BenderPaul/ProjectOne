

/*
async function addReimbursement(){
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
    };
    console.log(JSON.stringify(reimbursement));
   const fetched = await fetch('http://localhost:8080/Project1/reimb.json',{
        method: 'post',
        body: JSON.stringify(reimbursement)
   }); 
};

//document.getElementById("claimSubmit").onclick = addReimbursement;*/