package io.machine.machine.io.config;

import io.machine.machine.io.models.Chamado;
import io.machine.machine.io.models.Maquina;
import io.machine.machine.io.models.Operador;
import io.machine.machine.io.models.Supervisor;
import io.machine.machine.io.repositories.ChamadoRepository;
import io.machine.machine.io.repositories.MaquinaRepository;
import io.machine.machine.io.repositories.OperadorRepository;
import io.machine.machine.io.repositories.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private MaquinaRepository maquinaRepository;

    @Autowired
    private OperadorRepository operadorRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Autowired
    private ChamadoRepository chamadoRepository;

    @Override
    public void run(String... args) throws Exception {

        Maquina m1 = new Maquina("DTA123456JBTNET","DELL 3020","123 456 789",true);
        Maquina m2 = new Maquina("DTA321987JBTNET","DELL 3020","321 654 456",true);
        Maquina m3 = new Maquina("DTA987654JBTNET","DELL 3020","654 987 258",true);
        Maquina m4 = new Maquina("DTA654987JBTNET","DELL 3020","321 369 654",true);

        Supervisor s1 = new Supervisor("123455",
                "Rayane Maciel",
                "NET",
                "81999275749",
                "977832");

        Operador o1 = new Operador("123456",
                "Rodolfo Santos de Lima",
                "NET",
                "81999275748",
                m3,
                s1,
                "12345678998");

        Chamado c1 = new Chamado(s1,m1, Instant.now(),null);


        maquinaRepository.saveAll(Arrays.asList(m1,m2,m3,m4));
        supervisorRepository.save(s1);
        operadorRepository.save(o1);
        chamadoRepository.save(c1);

    }
}
