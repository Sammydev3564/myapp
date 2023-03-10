def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerlogin', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t sammydev3564/my-repo:v2.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push sammydev3564/my-repo:v2.1'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
