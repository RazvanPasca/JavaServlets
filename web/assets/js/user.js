init = () =>
{

    const buttons = document.getElementsByTagName("button");

    for (let button of buttons) {
        button.onclick = () =>
        {
            getFlightCoords(button);
        }
    }

    const pop_up = document.getElementById("pop-up");
    const h3 = document.getElementById("arrivalTime");


    style = {
        background: "mediumpurple",
        position: "absolute",
        top: "120px",
        left: "60%",
        display:"block",
        opacity:".8",
        padding: "20px"
    };


    if (h3.innerHTML.length === 0)
        pop_up.style.display = "none";
    else
       Object.assign(pop_up.style, style);

    pop_up.onclick = () => {
        pop_up.parentNode.removeChild(pop_up);
    }
}

getFlightCoords = (button) =>
{
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
