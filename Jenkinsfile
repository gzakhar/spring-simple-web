pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
    disableConcurrentBuilds()
  }

  stages {
    stage('mvn clean install') {

      steps {

        withMaven(maven: 'Maven 3.6.3') {
          sh 'mvn clean install source:jar -DskipTests=true'
//              sh 'mvn clean install'
        }

        withMaven(maven: 'Maven 3.6.3'){
            sh 'mvn deploy'
        }
      }

    }
  }
}