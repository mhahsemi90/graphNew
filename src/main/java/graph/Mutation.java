package graph;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import java.util.List;

public class Mutation implements GraphQLRootResolver {
    private final PersonRepository personRepository;
    private final ParamRepository paramRepository;
    private final PersonParamValueRepository personParamValueRepository;
    private final PersonTransactionRepository personTransactionRepository;
    private final CalculationTransactionRepository calculationTransactionRepository;

    public Mutation(PersonRepository personRepository
            , ParamRepository paramRepository
            , PersonParamValueRepository personParamValueRepository
            , PersonTransactionRepository personTransactionRepository
            , CalculationTransactionRepository calculationTransactionRepository) {
        this.personRepository = personRepository;
        this.paramRepository = paramRepository;
        this.personParamValueRepository = personParamValueRepository;
        this.personTransactionRepository = personTransactionRepository;
        this.calculationTransactionRepository = calculationTransactionRepository;
    }

    public Person createPerson(String code, String firstName, String lastName) {
        Person person = new Person(code, firstName, lastName);
        System.out.println(person.getCode() + person.getFirstName() + person.getLastName());
        personRepository.savePerson(person);
        return person;
    }

    public Param createParam(String code, String title) {
        Param param = new Param(code, title);
        paramRepository.savePerson(param);
        return param;
    }

    public PersonParamValue createPersonParamValue(Boolean isValid, Float value, String paramId, String personTransactionId){
        PersonParamValue personParamValue = new PersonParamValue(isValid,Double.valueOf(value),paramId,personTransactionId);
        personParamValueRepository.savePersonParamValue(personParamValue);
        return personParamValue;
    }

    public PersonTransaction createPersonTransaction(String type, String personId, String calculationTransactionId){
        PersonTransaction personTransaction = new PersonTransaction(type,personId,calculationTransactionId);
        personTransactionRepository.savePersonTransaction(personTransaction);
        return personTransaction;
    }
    public CalculationTransaction createCalculationTransaction(String year, String month){
        CalculationTransaction calculationTransaction = new CalculationTransaction(year,month);
        calculationTransactionRepository.saveCalculationTransaction(calculationTransaction);
        return calculationTransaction;
    }
}
