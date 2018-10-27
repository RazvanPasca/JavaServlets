init = () => {

    const buttons = document.getElementsByTagName("button");
    for (let button of buttons) {
        button.onclick = () => {
            getFlightCoords(button);
        }
    }

}

getFlightCoords = (button) => {
    let form = document.createElement('form');
    form.setAttribute('method', 'get');
    form.setAttribute('action', '/getLocalArrival');

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
