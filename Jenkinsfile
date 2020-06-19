pipeline {
  agent any

  options {
    buildDiscarder(logRotator(numToKeepStr: '5'))
    disableConcurrentBuilds()
  }

  stages {
    stage('mvn clean install') {
      steps {
//         withMaven(globalMavenSettingsConfig: 'GlobalMavenSettings.xml.20171122',
        withMaven(maven: 'Maven 3.5.0') {
          sh 'mvn clean install source:jar -DskipTests=true'
        }
      }
    }


//     stage('mvn deploy') {
//       steps {
//         withMaven(globalMavenSettingsConfig: 'GlobalMavenSettings.xml.20171122',
//                   maven: 'Maven 3.5.0') {
//           sh 'mvn source:jar deploy -DskipTests=true'
//         }
//       }
//     }
//     stage('mvn docker:build -DpushImageTag') {
//       steps {
//         withMaven(globalMavenSettingsConfig: 'GlobalMavenSettings.xml.20171122',
//                   maven: 'Maven 3.5.0') {
//           sh 'mvn docker:build -DpushImageTag'
//         }
//       }
//     }
  }
}