/*function ajaxGetRequest(url, expression, method = "get"){
    //step 1
    const xhr = new XMLHttpRequest();

    //step 2
    xhr.onreadystatechange = () => {
        if(xhr.readystate === 4 && xhr.status === 200){
            const jsonResponse = JSON.parse(xhr.responseText);
            expression(jsonResponse);
        }
    }

    //step 3
    xhr.open(method, url);

    //step 4
    xhr.send();
}

function fetchGetRequest(url){
    return fetch(url)
    .then((response) => response.json())
    .then((result) => result);
}

async function asyncFetch(url, expression){
    const response = await fetch(url);
    const json = await response.json();
    expression(json);
}

*/