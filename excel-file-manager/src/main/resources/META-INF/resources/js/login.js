
window.addEventListener('load', function () {
    var url = window.location.href;
    var msg = document.getElementById('errorMessage');
    if(typeof(msg) === 'undefined' || msg !== null){
        return;
    }
    if (url.search('error') > 0) {
        msg.style.display = "block";
    }
}, false);