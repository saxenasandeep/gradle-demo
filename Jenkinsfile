pipeline{
  agent any
  stages{
    stage('checkout'){
      steps {
        echo 'checkout files:'
      }
    }
    stage('compile'){
      steps{
        sh './gradlew clean build --stacktrace'
      }
    }
   }

}
