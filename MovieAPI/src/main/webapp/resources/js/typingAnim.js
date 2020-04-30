var typing = document.getElementById('gocoder_typing');

var typewriter = new Typewriter(typing, {
	loop : true
});

typewriter.typeString('영화를 검색해주세요.').pauseFor(2500).deleteAll().start();
