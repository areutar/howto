package string.deleteComments.tests;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;
import string.deleteComments.DeleteComments;

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
                Arguments.of("sampleefnwofewjiefw\n" +
                        "wjiefweofiwefinofewnniofweniobiewfibuewf\n" +
                        "wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio\n" +
                        "fewkfnweo oiwefnwfiwni oinwefinniwfineiwno\n" +
                        "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk",
                        "sampleefnwofewjiefw\n" +
                                "wjiefweofiwefinofewnniofweniobiewfibuewf\n" +
                                "wiognweifninoewf wefionw oifn oewniffeoiwn wniewfonifewnio\n" +
                                "fewkfnweo oiwefnwfiwni oinwefinniwfineiwno\n" +
                                "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk"),
                Arguments.of("print(\"Введите своё имя\")\n" +
                        "name = input()\n" +
                        "print(\"Введите пароль, если имеется\")    //  ахахахах вам не поймать меня\n" +
                        "password = input()\n" +
                        "if password == \"hoover\":\n" +
                        "    print(\"Здравствуйте, рыцарь\", name)         // долой Макнамару\n" +
                        "elif password == \"noncr\":\n" +
                        "    print(\"Здравствуйте, паладин\", name)\n" +
                        "elif password == \"gelios\":\n" +
                        "    print(\"Здравствуйте, старейшина\", name)          // Элайджа вперёд\n" +
                        "else:\n" +
                        "    print(\"Здравствуйте, послушник\", name)",
                        "print(\"Введите своё имя\")\n" +
                                "name = input()\n" +
                                "print(\"Введите пароль, если имеется\")\n" +
                                "password = input()\n" +
                                "if password == \"hoover\":\n" +
                                "    print(\"Здравствуйте, рыцарь\", name)\n" +
                                "elif password == \"noncr\":\n" +
                                "    print(\"Здравствуйте, паладин\", name)\n" +
                                "elif password == \"gelios\":\n" +
                                "    print(\"Здравствуйте, старейшина\", name)\n" +
                                "else:\n" +
                                "    print(\"Здравствуйте, послушник\", name)"),
                                Arguments.of("kdeaefk                           //tndjwd\n" + 
                                        "awk()()!!!                    //ttttt\n" + 
                                        "fowk\n" + 
                                        "ttttttttt\n" + 
                                        "pewrjwermwk //jelwee\n" + 
                                        "kekekekekekekekekekeke",
                                "kdeaefk\n" + 
                                        "awk()()!!!\n" + 
                                        "fowk\n" + 
                                        "ttttttttt\n" + 
                                        "pewrjwermwk\n" + 
                                        "kekekekekekekekekekeke")
                                );
    }
}
