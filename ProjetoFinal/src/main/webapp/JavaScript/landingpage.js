// DROPDOWN -------------------------------------------------------------------------------------------
    const downdropElements = document.getElementsByClassName('downdrop');
    const underpElements = document.getElementsByClassName('underp');
    const underdropElements = document.getElementsByClassName('underdrop');

    const toggleDropdown = (index, show) => {
        const transform = show ? 'translateY(0px)' : '';
        const width = show ? '100%' : '0';

        underpElements[index].style.transform = transform;
        underdropElements[index].style.width = width;
    };

    const dropdown = () => toggleDropdown(0, true);
    const dropdownf = () => toggleDropdown(0, false);

    const dropdown1 = () => toggleDropdown(1, true);
    const dropdownf1 = () => toggleDropdown(1, false);

    const dropdown2 = () => toggleDropdown(2, true);
    const dropdownf2 = () => toggleDropdown(2, false);

// // CARROSEL ----------------------------------------------------------------------------------------
//     //Bom, pessoal, esse aqui é um códig de teste para o interdisciplinar:


// // declarei variáveis 
// const images = document.querySelectorAll('.conteiner img'); // essa é uma constante que recebe o valor armazenado na tag img que está dentro de uma div chamada container

// let currentIndex = 0; // já essa é um contador para identificar qual o index da imagem que está a mostra


// function showImage(index) { //função que "mostra a imagem"
//     images.forEach((img, i) => { // forEach é um for para contar itens em vetors. O js reconhjece as tags img como itens de um vetor chamado de .conteiner
//         img.classList.remove('active')// aqui é removido a classe active da img deixando ele com opacidade 0;
//         if (i === index) {
//             img.classList.add('active');
//         } // o contador vai andando a cada x segindos e caso o contador seja igual ao numero da imagemele adiciona o active e a imagem volta a aparecer
//     });
// }


// //funções para a chamada manual essas funções são chamadas quando há o click nos botôes de próximo ou anterior

// function nextImage() {
//     currentIndex = (currentIndex + 1) % images.length;// como eu disse, o index vai sendo atualizado. Nesse caso é para a imagem posterior 
//     showImage(currentIndex); // a função nextImage chama a função showImage
// }

// function prevImage() {
//     currentIndex = (currentIndex - 1 + images.length) % images.length;// aqui o contador é decrementado e no caso da imagem anterior 
//     showImage(currentIndex);
// }

// //função para a chamada automática (conforme o tempo passa)

// document.addEventListener('DOMContentLoaded', () => { // ´´e adicionado um evento. Esse evento é adicionado sempre que a página é carregada(ou seja, sempre)
//     showImage(currentIndex); 

//     setInterval(nextImage, 3000); 

//     //verifica se há algum click nos botões. se houver é chamada a funç~o passada como parâmetro
//     document.querySelector('.next').addEventListener('click', nextImage);//avança imagem 
//     document.querySelector('.prev').addEventListener('click', prevImage);// volta a imagem
// });