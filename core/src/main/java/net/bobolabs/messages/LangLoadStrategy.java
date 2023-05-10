package net.bobolabs.messages;

/*

    - lang.yml

    - lang/
        file1.yml
        file2.yml

    - lang/
        lang_en_US.yml
        lang_it_IT.yml

    - lang/
        en_US/
            file1.yml
            file2.yml
        file3.yml
        file4.yml

    - lang/
        en_US/
            file1.yml
            file2.yml
        it_IT/
            file1.yml
            file2.yml
        file3.yml
        file4.yml

*/

public enum LangLoadStrategy {

    SIMPLE,
    FILE,
    DIRECTORY

}
