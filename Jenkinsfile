pipeline {
    agent  { label 'java-11' }
    stages {
        
          stage ("Build") {

                steps{
                    withMaven() {
                        sh "./mvnw verify"
                    }   
                }
            }
            stage ("Deploy to CloudFoundry") {
                    
                steps {
                    withCfCli(
                        apiEndpoint: 'https://api.run.pivotal.io', 
                        cloudFoundryCliVersion: 'cloudfoundry-cli-6.22.1', 
                        credentialsId: 'nofar_cf', 
                        organization: 'cloudbees', 
                        space: 'development') 
                    {   
                    sh """cf push hello-world -p target/*.jar"""
                    }
                }
            }      
    }
    
    post { 
        failure { 
            echo "On Post-failue"
            slackSend channel: 'templates_demo', color: '#FF0000',message: 'This is the message', teamDomain: 'cloudbees', tokenCredentialId: 'Jenkins-slack-integration'
        }
        success{
            echo "On Post-success"
            slackSend channel: 'templates_demo', color: '#439FE0',message: 'This is the message', teamDomain: 'cloudbees', tokenCredentialId: 'Jenkins-slack-integration'
        }
    }
}
