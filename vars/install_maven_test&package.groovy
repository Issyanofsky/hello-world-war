def call() {
  sh '''
    MAVEN_VERSION=3.8.3
    MAVEN_URL=https://dlcdn.apache.org/maven/maven-3/3.9.9/binaries/apache-maven-3.9.9-bin.tar.gz
                        
    mkdir -p ./maven
    curl -s $MAVEN_URL | tar -xz -C ./maven --strip-components=1
    ls -alh ./maven
    export M2_HOME=./maven
    export PATH=\$M2_HOME/bin:\$PATH
    mvn -version
    mvn clean
    mvn compiler:compile
    mvn compiler:testCompile
    mvn package
    ls -alh target
                        
    '''
}
