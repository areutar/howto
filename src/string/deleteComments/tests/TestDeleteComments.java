package string.deleteComments.tests;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import string.deleteComments.DeleteComments;
import static string.deleteComments.DeleteComments.sep;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestDeleteComments {
    @ParameterizedTest
    @MethodSource("provideParams")
    void testDeleteComments(String code, String expected) {
        assertEquals(expected, DeleteComments.deleteComments(code));
    }

    private static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of("privet(@*)(!$&(%(@)%                           // wewjf wfmweo qikfwif",
                        "privet(@*)(!$&(%(@)%"),
                Arguments.of("sampleefnwofewjiefw" + sep +
                        "wjiefweofiwefinofewnniofweniobiewfibuewf" + sep +
                        "wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio" + sep +
                        "fewkfnweo oiwefnwfiwni oinwefinniwfineiwno" + sep +
                        "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk",
                        "sampleefnwofewjiefw" + sep +
                                "wjiefweofiwefinofewnniofweniobiewfibuewf" + sep +
                                "wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio" + sep +
                                "fewkfnweo oiwefnwfiwni oinwefinniwfineiwno" + sep +
                                "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"),
                Arguments.of("print(\"Введите своё имя\")" + sep +
                        "name = input()" + sep +
                        "print(\"Введите пароль, если имеется\")    //  ахахахах вам не поймать меня" + sep +
                        "password = input()" + sep +
                        "if password == \"hoover\":" + sep +
                        "    print(\"Здравствуйте, рыцарь\", name)         // долой Макнамару" + sep +
                        "elif password == \"noncr\":" + sep +
                        "    print(\"Здравствуйте, паладин\", name)" + sep +
                        "elif password == \"gelios\":" + sep +
                        "    print(\"Здравствуйте, старейшина\", name)          // Элайджа вперёд" + sep +
                        "else:" + sep +
                        "    print(\"Здравствуйте, послушник\", name)",
                        "print(\"Введите своё имя\")" + sep +
                                "name = input()" + sep +
                                "print(\"Введите пароль, если имеется\")" + sep +
                                "password = input()" + sep +
                                "if password == \"hoover\":" + sep +
                                "    print(\"Здравствуйте, рыцарь\", name)" + sep +
                                "elif password == \"noncr\":" + sep +
                                "    print(\"Здравствуйте, паладин\", name)" + sep +
                                "elif password == \"gelios\":" + sep +
                                "    print(\"Здравствуйте, старейшина\", name)" + sep +
                                "else:" + sep +
                                "    print(\"Здравствуйте, послушник\", name)"),
                                Arguments.of("kdeaefk                           //tndjwd" + sep + 
                                        "awk()()!!!                    //ttttt" + sep + 
                                        "fowk" + sep + 
                                        "ttttttttt" + sep + 
                                        "pewrjwermwk //jelwee" + sep + 
                                        "kekekekekekekekekekeke",
                                "kdeaefk" + sep + 
                                        "awk()()!!!" + sep + 
                                        "fowk" + sep + 
                                        "ttttttttt" + sep + 
                                        "pewrjwermwk" + sep + 
                                        "kekekekekekekekekekeke")
                                );
    }
}
