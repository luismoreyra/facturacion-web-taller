node {

    stage('Descargar fuentes') {
        git credentialsId: 'luis.moreyra.reyna@gmail.com', url: 'https://github.com/luismoreyra/facturacion-web-taller.git'
    }

}


