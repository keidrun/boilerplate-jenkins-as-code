job('NodeJS Basic Job') {
    scm {
        git('https://github.com/keidrun/target_repo.git') {  node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@example.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs_v11')
    }
    steps {
        shell("npm install")
        shell("npm test")
    }
}
