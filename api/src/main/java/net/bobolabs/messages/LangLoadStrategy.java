package net.bobolabs.messages;

/*

    - lang.yml          // UnlocalizedFileStrategy

    - lang/             // UnlocalizedDirectoryStrategy
        file1.yml
        file2.yml

    - lang/             // LocalizedFileStrategy
        lang_en_US.yml
        lang_it_IT.yml
        common.yml

    - lang/             // LocalizedDirectoryStrategy
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
