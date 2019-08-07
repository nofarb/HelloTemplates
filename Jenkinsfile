pipeline {
    agent any
    stages {
        
          stage ("Build") {

                steps{
                    withMaven() {
                        sh "./mvnw verify"
                }
                     sh "ls -lat"
                            sh "pwd"
                }
            }
                stage ("deploy to Development") {
                    
                      steps {
                          sh "ls -lat"
                            sh "pwd"
                    withCfCli(
                        apiEndpoint: 'https://api.run.pivotal.io', 
                        cloudFoundryCliVersion: 'cloudfoundry-cli-6.22.1', 
                        credentialsId: 'nofar_cf', 
                        organization: 'cloudbees', 
                        space: 'development') {
                        sh """
                        cf push hello-world -p target/*.jar
                        """
                    }
                      }
            }      
      
    }
    
       post { 
        failure { 
            echo "On Post-failue"
                        slackSend channel: 'templates_demo', color: '#439FE0',message: 'This is the message', teamDomain: 'cloudbees', tokenCredentialId: 'Jenkins-slack-integration'

              
        }
           success{
               echo "On Post-success"
                        slackSend channel: 'templates_demo', color: '#439FE0',message: 'This is the message', teamDomain: 'cloudbees', tokenCredentialId: 'Jenkins-slack-integration'

              
           }
    }
}


