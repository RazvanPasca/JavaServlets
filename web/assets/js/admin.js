init = () =>{
    const buttons = document.getElementsByTagName("button");

    for (let button of buttons){
        button.onclick = () => {
            deleteFlight(button);
        }
    }
}

deleteFlight = (button) => {
    let form = document.createElement('form');
    form.setAttribute('method', 'post');
    form.setAttribute('action', '/deleteFlight');

    let input = document.createElement('input');
    input.setAttribute("type", "hidden");
    input.setAttribute("name", "flightId");
    input.setAttribute("value", button.value);

    form.style.display = 'hidden';
    form.appendChild(input);
    document.body.appendChild(form);
    form.submit();
}

window.onload = init;