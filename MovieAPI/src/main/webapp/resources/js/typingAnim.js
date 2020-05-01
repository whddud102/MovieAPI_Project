var app = document.getElementById('app');

var typewriter = new Typewriter(app, {
  loop: true,
  delay: 100,
});

typewriter
  .pauseFor(1000)
  .typeString("영화를 ")
  .pauseFor(700)
  .typeString("검색해주세요.")
  .pauseFor(1500)
  .start();
