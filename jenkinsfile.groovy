node {

    stage('Descargar fuentes') {
        git credentialsId: 'luis.moreyra.reyna@gmail.com', url: 'https://github.com/luismoreyra/facturacion-web-taller.git'
    }

    stage('Compilar') {
        bat 'mvn clean compile'
    }

    stage('Pruebas Unitarias') {
        echo 'Ejecutando Pruebas Unitarias ...'
        bat 'mvn test'
        junit '**/target/surefire-reports/*.xml'
    }

    stage('Pruebas de Integracion') {
        echo 'Ejecutando Pruebas de Integracion ...'
        bat 'mvn verify -DskipUTs=true'
        junit '**/target/failsafe-reports/*.xml'
    }

    stage('Analisis de codigo estatico') {
        echo 'Analizando codigo con SonarQube ...'
        withSonarQubeEnv('sonar-devops') {
            bat 'mvn sonar:sonar'
        }
    }

}


