/*LAZY LOADING*/
const img = document.querySelectorAll('img');

function intersection(entries, observer) {
  entries.forEach(entry => {
    console.log('intersection', entry.target);
    if (!entry.isIntersecting) {
      return
    }
    entry.target.src = entry.target.dataset.src;
    observer.unobserve(entry.target);

  });
}

const options = {
  root: null,
  rootMargin: '0px',
  threshold: 0.5
};

const observer = new IntersectionObserver(intersection, options);

img.forEach(i => {
  observer.observe(i);
});
/*LAZY LOADING*/

/*HAMBURGUER from = to x*/
const hamburger = document.querySelector("#hamburger");
hamburger.addEventListener("click", () => {
  hamburger.classList.toggle("active");
});
function myMenuMobile() {
  var x = document.getElementById("menuPhone");
  if (x.style.display === "block") {
    x.style.display = "none";
  } else {
    x.style.display = "block";
  }
}
/*HAMBURGUER*/


/*MULTIPLE SLIDES*/
var slideshowContainers = document.getElementsByClassName("cardSlide");

for (let s = 0; s < slideshowContainers.length; s++) {
  var cycle = slideshowContainers[s].dataset.cycle;
  var slides = slideshowContainers[s].querySelectorAll('.photos');
  var slideIndex = 0;
  showSlides(slides, slideIndex, cycle);
};
function showSlides(slides, slideIndex, cycle) {
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  };
  slideIndex++;
  if (slideIndex > slides.length) {
    slideIndex = 1
  };
  slides[slideIndex - 1].style.display = "block";
  setTimeout(function () {
    showSlides(slides, slideIndex, cycle)
  }, cycle);
};
/*MULTIPLE SLIDES*/

/*SLIDES - MY SLIDES*/
var slideIndex = 0;
carousel();
function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  slideIndex++;
  if (slideIndex > x.length) { slideIndex = 1 }
  x[slideIndex - 1].style.display = "block";
  setTimeout(carousel, 2500); // Change image every x(1000=1) seconds
}
/*SLIDES - MY SLIDES*/


/*CARDS*/
var cardIndex = 1;
showCards(cardIndex);
function plusSlides(n) {
  showCards(cardIndex += n);
}
function currentSlide(n) {
  showCards(cardIndex = n);
}


  function showCards(n) {
    var i;
    if (window.innerWidth <= 768) {
    var cards = document.getElementsByClassName("myCards");
    if (n > cards.length) { cardIndex = 1 }
    if (n < 1) { cardIndex = cards.length }
    for (i = 0; i < cards.length; i++) {
      cards[i].style.display = "none";
    }
    cards[cardIndex - 1].style.display = "block";
  }
}

/*CARDS*/


/*MULTIPLE SLIDES*/
var slideshowContainers = document.getElementsByClassName("cardSlide");

for (let s = 0; s < slideshowContainers.length; s++) {
  var cycle = slideshowContainers[s].dataset.cycle;
  var slides = slideshowContainers[s].querySelectorAll('.photos');
  var slideIndex = 0;
  showSlides(slides, slideIndex, cycle);
};
function showSlides(slides, slideIndex, cycle) {
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  };
  slideIndex++;
  if (slideIndex > slides.length) {
    slideIndex = 1
  };
  slides[slideIndex - 1].style.display = "block";
  setTimeout(function () {
    showSlides(slides, slideIndex, cycle)
  }, cycle);
};
/*MULTIPLE SLIDES*/