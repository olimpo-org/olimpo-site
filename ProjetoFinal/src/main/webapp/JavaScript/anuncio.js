document.addEventListener('DOMContentLoaded', () => {
    const upload = document.getElementById('upload');
    const visualizar = document.getElementById('visualizar');
    const prompt = document.getElementById('prompt');
    
    // Quando a área da imagem é clicada, ativa o input para colocar imagem
    visualizar.addEventListener('click', () => {
        upload.click();
    });

    upload.addEventListener('change', () => {
        const file = upload.files[0];
        if (file) {
            const reader = new FileReader();

            reader.onload = (e) => {
                visualizar.style.backgroundImage = `url(${e.target.result})`; // Define a imagem de visualização
                prompt.style.display = 'none'; // Esconde o texto de upload
            };

            reader.readAsDataURL(file); // Lê a imagem como URL

            // Chama a função para upload da imagem
            uploadImageToFirebase(file); // Chama a função de upload
        }
    });
});

// Função para upload da imagem no Firebase
function uploadImageToFirebase(file) {
    const storageRef = ref(storage, 'images/' + file.name); // Referência do caminho no Firebase
    const uploadTask = uploadBytesResumable(storageRef, file);

    uploadTask.on('state_changed', 
        (snapshot) => {
            // Progresso do upload, se necessário
            const progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            console.log('Progresso: ' + progress + '%');
        }, 
        (error) => {
            console.error("Erro ao fazer upload:", error);
        }, 
        () => {
            // Upload concluído, obtenha a URL de download
            getDownloadURL(uploadTask.snapshot.ref).then((downloadURL) => {
                console.log('Arquivo disponível em:', downloadURL);
                // Aqui você pode usar a URL de download conforme necessário
            });
        }
    );
}
