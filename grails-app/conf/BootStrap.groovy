import com.viseo.ciwalle.Jenkins
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if (Environment.current == Environment.DEVELOPMENT) {
            new Jenkins(name: 'synaps', description: 'IC Synaps', url: 'http://172.30.250.134:8080').save()
            new Jenkins(name: 'weleda', description: 'IC Weleda', url: 'http://172.30.250.197:8081').save()
        }
    }
    def destroy = {
    }
}
