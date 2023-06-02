def call () {
  sh 'ls **/target/surefire-reports/'
  jacoco()
}
