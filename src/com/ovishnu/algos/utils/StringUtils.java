package com.ovishnu.algos.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringUtils {
    public String reverseWords(String s) {
        final String[] stringArray = s.split(" ");
        List<String> words = Arrays.asList(stringArray);
        Collections.reverse(words);
        String reverse = new String();
        for (String word : words) {
            System.out.println("Word is " + word);
            if (!word.trim().isEmpty()) {
                reverse = reverse.concat(word + " ");
            }
        }

        return reverse.trim();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        int skippedFirstCheckCounter = 0, skippedSecondCheckCounter = 0, total = 0;
        int firstCheckPalindrome = 0, secondCheckPalindrome = 0;
        final List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                total++;
                String reversedFirst = (new StringBuffer(words[i])).reverse().toString();
                if (words[i].length() > words[j].length()) {
                    if (!reversedFirst.startsWith(words[j]) && !reversedFirst.endsWith(words[j])) {
                        skippedFirstCheckCounter++;
                        continue;
                    }
                }

                String reversedSecond = (new StringBuffer(words[j])).reverse().toString();
                if (words[j].length() > words[i].length()) {
                    if (!reversedSecond.startsWith(words[i]) && !reversedSecond.endsWith(words[i])) {
                        skippedSecondCheckCounter++;
                        continue;
                    }

                }

                if (!words[i].contains(words[j]) && !words[j].contains(words[i])) {
                    // System.out.println("Skipped second check");
                    skippedSecondCheckCounter++;
                    continue;
                }

                final String concatenated1 = new String(words[i]);
                if (isPalindrome(concatenated1.concat(words[j]))) {
                    final List<Integer> indexList = new ArrayList<>();
                    indexList.add(Integer.valueOf(i));
                    indexList.add(Integer.valueOf(j));

                    result.add(indexList);
                    firstCheckPalindrome++;
                }

                final String concatenated2 = new String(words[j]);
                if (isPalindrome(concatenated2.concat(words[i]))) {
                    final List<Integer> indexList = new ArrayList<>();
                    indexList.add(Integer.valueOf(j));
                    indexList.add(Integer.valueOf(i));

                    result.add(indexList);
                    secondCheckPalindrome++;
                }

            }
        }

        System.out.println("skippedFirstCheckCounter: " + skippedFirstCheckCounter + " skippedSecondCheckCounter: "
                + skippedSecondCheckCounter + " firstCheckPalindrome " + firstCheckPalindrome
                + " secondCheckPalindrome " + secondCheckPalindrome + " total " + total);
        return result;
    }

    private boolean isPalindrome(final String str) {
        if (str.isEmpty())
            return true;
        final char[] strArray = str.toCharArray();
        int start = 0, end = strArray.length - 1;

        while (start <= end) {
            if (strArray[start++] != strArray[end--]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = { "aihhieeegdebhb", "acajjajbbibaab", "ddjihhebahcead", "cehdaiaeaggai", "di",
                "bcacdfjadgfjgiicghc", "ddhigcdidggfcejib", "djbgdcadgiaaieh", "fggfdajadcfhajhag", "dfahbdjcbgdf",
                "dfbhhdfjdcfefij", "fjgbegdifedgf", "ffeice", "gdgjcaichica", "gigjifehagcacggg", "ehjgha", "ddj",
                "igffdiddgecidcjfj", "cca", "heeig", "cdghidigcgdaeda", "jbbachabahheidacd", "feahagifaacejg",
                "abdbgidheigfcabffe", "ehcbieidgfagijafd", "gcji", "f", "jddgd", "ibachgei", "eeabadcbiebdchiaha",
                "baejcdeef", "cagbjjhaecgi", "ijfcfecdccchee", "jhiidcdba", "dgdibjihcbbhg", "fcibbcbbjhhbiiiaag",
                "fggefjgbjdajcbcgjbj", "gg", "hhadjfeaa", "aghbgcjfcdcihfc", "bfffcggfeddeajbhafge", "dggfafhafc",
                "dcdbhcifbbbgbcaeh", "dacacdhbjd", "ghhifd", "aabifcjhadibhfdjbga", "baejceehiagaabchabff", "bjagbabf",
                "hgijgdifccjdehjaccbf", "gbfejbfddgcja", "iiedgaigdg", "eeieg", "cei", "bchicbfcihbcjejjfg", "jhjdfi",
                "ebdgaghfbjhfceh", "bdjdgegfdddadiieaici", "abeecj", "g", "jcadaigbcabcggeddjcd", "h", "ajjg",
                "iebcbgfbjhbfbai", "ghj", "gidafdigfgfcjfg", "hgjacihicbcfifghgcbc", "gaaibecj", "ifjciedfgdegfi",
                "bfcbdddjfjjhfahbjfaa", "fafgijfgahf", "gcjacdbgdbecghif", "gjdgah", "fdbbcbidbhbgf", "ghihccifb",
                "ghjeecjgfefd", "b", "egigbdaicefieddicee", "gjg", "baae", "jeiehgccjefedjib", "jjcjgeaajcj",
                "ihjbhbjgejgcheb", "accce", "jhc", "gjj", "icaadccfihj", "bafefdchbhibibdfggg", "egehfbegjedcicdfjfge",
                "fbcdighdcieideh", "bjfibbjigc", "daidhjjb", "aeeec", "ed", "dgdbjjibccjdafh", "bbde", "biejhahgd",
                "bjhhdiidcbe", "dibceifgj", "c", "hedi", "fjjfihdejifjfba", "hd", "bffbd", "gdjaaaaihgbiahicde",
                "gdehfchcd", "icgidjcj", "gd", "jddfjhcgiefjee", "daajiighijhdfbi", "bggj", "ecgfbahaacfiajc",
                "ggdffajibaidjib", "jf", "fhicadfghdcchiiifj", "aji", "gfjacgcfbicgdjad", "cfhfcggadigidigihdid",
                "bfcdidiifgfbc", "ahiidhjhbfdiahic", "edecdcd", "cigigjfafdbhbdhhhjf", "fbjefgghghcheja",
                "dhcheddfjffeejb", "ffcd", "ificcdfdb", "ghjgafhiffdcgghjja", "jgfadaecjgh", "fifahiijidjgcdiedee",
                "dccejgdfaggdadfccd", "aeghbjdjgifah", "gejaehchdfhfdeegie", "bafa", "aebgccebdfcgc", "abdgbcg",
                "dcedgfjbbgc", "jbfhaddbbdaiiegjic", "jegdijdaebj", "ejgajggidiahadgddeab", "ece", "i",
                "hegjjfbgegijdjgb", "aiiee", "eefad", "cdbeifbfa", "afej", "hagaadb", "egfdib", "hfaiididcidfjccf",
                "debf", "ddhceh", "hjgecgjjihf", "fjjfj", "gjceffcedjff", "aaaghiabbdagbchhg", "dgaieejgbfjdhcbcijfa",
                "cacf", "cbjbijehadihhjdi", "fiabgiiccbba", "eagi", "edaagghhehgddic", "egcaghjcfci", "cjbhgfbdfddh",
                "jbjdhghgjjjacgidfbeg", "icjihhgeffbhihhdh", "caceeibgbihcfidbig", "efij", "ahjgfdegbig",
                "cieifgigjdbje", "iebahhbjjbjiegaca", "bjiheaiaacajdjbdbe", "gbgbcdge", "bdaijhgefjibfhcedc",
                "gjgfbhhdedhb", "hedbgdbajfg", "eiebdiiedhagad", "a", "digcdgjejhf", "aaiafddgcefj", "dhba", "d", "ag",
                "bbchdccbgjfbjcgfci", "afg", "cbjgjfffj", "ccgifgeccjgc", "jhbgb", "dfggiifehbf", "hfhedbgjdhfghgdja",
                "fagjbdge", "cejhjbccgjggihcgeaf", "dbhbfebffgaf", "cdhdjhcj", "hacjbaifjb", "gjejjbbbecidahjched",
                "jadfiigjidfgfa", "efjggaebaa", "heieaihfffj", "ejeafadace", "jfajijdifijacbhjc", "fig",
                "cehegedcdjcijehaeac", "dgjeijfae", "dcbeddfdb", "gdd", "ad", "eafdbedfdgeiiif", "dagihgebabiahhaf",
                "fiifhdbfhhbb", "dfc", "eajigcfifjjdhdhjadf", "egccbbhgddggebehebhc", "debahdfadag", "fhhcedjachdcjhd",
                "iaaicjbgejjaihcdaab", "jggbiee", "gigdjccjficebidhjdcj", "fa", "aehaghjbfibcd", "ceiicfbfgccbfjbi",
                "ieheijg", "bhcffafei", "ahhihfjja", "bdiihbciicfbhead", "bebihe", "dedigbeddahabdfa",
                "dcehfcbhibiihhg", "bdbdaifcbediabebhee", "ghbgecjcidafbgfad", "bfiaafcbdijj", "jffeijjijcbeihgbccfj",
                "fafbbjgagjbdd", "jcejgd", "dffgjfdibfabjgddcb", "acdhaebbiiacffgcdj", "ifibah", "fighebjccg",
                "jehejgdgiddebehfhdba", "ffebafcaafcgadfjai", "icjcdgachddebbbhj", "hcchjbecfigah", "cdjfffgafhie",
                "fedaejjeedahhccg", "gdedhijcjh", "aaccbgifg", "dibffhffigaeegfg", "ba", "hg", "efa", "acifijeg",
                "cichjibjdhgajcdc", "ccejgejcgabafgb", "dhfi", "cdgdfcfbhaefbdddh", "aebdjf", "fdghbigifah",
                "jeegcicbfejc", "bebehc", "dgfgdhg", "jjfbifgfj", "gejbebejbfhb", "ghfhheeaddc", "iedah", "hfjchb",
                "hjhdfbjfigdbgbgggf", "ebfiecdghcfg", "eheiicbhiedi", "fjaa", "ccbeheejcicahhhj", "ebbjbd",
                "hafebbhfgdjbde", "aibjfcfe", "jbbdbjac", "ghdaec", "gbabhj", "e", "fcbjgibadfcdbd", "afahbhjjbad",
                "adadeiibjgchihgcdfjh", "dgadgfji", "ecidcfhajhdfcf", "dfeeebggedhfidede", "cadejafjaajaicd", "ibd",
                "dagf", "eigfajhfgdcbhi", "ce", "jdbgiefed", "bgffchfeebhejgh", "fj", "geddhdghcb",
                "jcabjacjhbiejjaehih", "gfchcjceadifii", "cgjjaai", "jicfgjciciihagd", "agcheaeahddheje",
                "jaaiehdhfhcbg", "ciafhfadeahiedgac", "fdecghgehfdigfa", "hajffedb", "hcjefhfeggbaafgcheh",
                "fdddcdchbhjgfig", "aghggjdcbehgccd", "ehfdj", "gbbgdb", "cdgjifidcdiejfga", "gbjdi",
                "fegicbfdhbdeicdac", "ijfbegfdjcbjcaddbcgg", "hihfjdadifh", "fdccdcdchdh", "ciciaejifbeefcciigb",
                "afcccc", "jfci", "fccje", "fd", "ebbgfdi", "bdcig", "ehbaji", "cbdjiffgfagagjbaid",
                "bejhcgdcaeaaibibca", "fhigfbfddfbai", "cgbadcgdchia", "jh", "aahjbj", "fddfahebabfajafgceb",
                "cbficcbhadchedcidg", "iihjdaedbb", "bbigheagfee", "ffggehgfificifdejga", "acidhghj", "bbbggfegjh",
                "bfcbhdied", "bejadihbdjid", "ajhfgjehaaabb", "fhgjjedajhb", "jejghcjfbgda", "ef", "jdcahjiahgfejaacc",
                "fjacgcjjfeb", "ggefjf", "jfejaah", "fbgfhefcegcbbihf", "igefidejfgdefjeg", "beaecfgjcda",
                "dffccaecieicbcgheeeh", "hbfaebjdi", "eddgcfjhbh", "ieheecbefgjhcjficb", "ia", "iibfefchhdei",
                "fjdcdccaefi", "gebcjejihhdjjbf", "jgee", "fc", "gdfaejbfbgeffffibb", "iciabibhihfcejdjggba",
                "bcfhfafj", "cchgaibghghjifehgdac", "gheheg", "fddbc", "jfebecgifdajh", "bjichcbbdhg", "eaeaaadc",
                "febhcc", "dba", "bafchg", "cbjbghgfjij", "ae", "cihijabjhd", "abjb", "ijiagdeh", "cjhdbbgdfh",
                "ffdgagecchicae", "iii", "iiejcideejjifiia", "dcb", "cgjc", "eeddie", "jedbfgdb", "bjiadfef",
                "fddjiejeghhafhjefb", "ebdfbfdbgdhcdjddigj", "hgiffaigdgehfdb", "geggc", "beiiagf", "gfbhjej",
                "jagadabjcgiceija", "gghidjhaeficjej", "eibggjgccfbhcad", "hhijjeaebbg", "chddicbchb", "iifgcbed",
                "ehcfbjaeahfbbdjgf", "idcdaajf", "ch", "aigigiehdbiehh", "egacbfbejh", "chhchhdfccagdidhed",
                "bceefjjjhhjdbj", "fgjdcigjaabiccfba", "bjhddhjjbbiajbchia", "fjbicdcgffadhgbdc", "gbgba",
                "ajjdffgegahf", "cbjfeeja", "egfjbfgghjeaeaaeiej", "edhgdgjgfiddfjddd", "hc", "dhaffehdh", "abaca",
                "fdfiajaehcddi", "ebddcj", "dejh", "jjfigabh", "bgiijbecafcag", "dfffjdabhegej", "fgjdjdcjhcidjgbhb",
                "adgaca", "jbadfgjfd", "ggbdbehbdbjbjif", "dbibg", "ifdgaihcaaif", "hfcicghddi", "dfgieidbddhcdbcc",
                "cg", "ecajej", "cegigiaejcbddgef", "j", "bbddbjebeccgjbbbifeg", "dgffdedej", "bcffhigji", "bacgeah",
                "cehfdaebaagjecfbfjeh", "ffdjbfjigfejheacec", "bhicaf", "feifehchcf", "eh", "cc",
                "fgebehacgggaafecahbi", "jdjdeg", "ceiegifagjdig", "egjf", "ichajgibiijbffhgjd", "hehjhhgjecihiaeh",
                "jjbfbjjgdjijhdefhe", "ieijjbabdiggbej", "jhggbgcbajigebb", "bb", "ciigfdigbajfjaajghh", "eai",
                "eaggcf", "jeefebecid", "fhaifhfiiighdgdgicf", "fcj", "iifd", "gbgcaefcf", "jjddcjfdchcdchce", "ee",
                "hiffa", "dcfda", "ijcfbbfbae", "hcbdhhg", "aheifdcjdgbccccjgadc", "ecjabjjbdefgjbbhj",
                "bfdjjcfbdfdcef", "icjfheiee", "hecff", "hccccjdgeafdjeebabca", "gibiafaihd", "idbaahbddg",
                "iieigidefdbddjc", "bcahbdifgjcfahcdfea", "djadjjgaebcg", "idjaeegcc", "beehcdcb", "ehbfdhffaa",
                "djjff", "igacfgdbjiedffia", "hdgabjaefahhcibiba", "bca", "eehfjb", "iibfigca", "gifgcaafddebajaedjdg",
                "ai", "ijgbjcjj", "ifdjjjfcabhijjgc", "hh", "ecfijbhfcajbfc", "iifcdifc", "ehf", "hjfedgdbcdcif",
                "ihhedgbedddegebcfi", "gc", "cfj", "eicigiaacghhfgch", "fjcdjadd", "idihdhjbfgdjeg",
                "fddbdfigfbgchdcaaehc", "cgdfef", "idicdcbihehdcdi", "bceibi", "ifehjcfbihjefaabhcc", "ieegghfahacidc",
                "adbicied", "ghbcdegb", "jeijjbbfgcdgjied", "geaad", "ajjbccgbifcdggafc", "accddbbhjcbhe", "fbfb",
                "jifgjhaadchj", "hgjhdifeiji", "gcjaddjjdgchdbcigch", "dghgehia", "jdiab", "fbad", "ebgiaabdbdehjce",
                "hahehbifa", "heigfcjigjabhaiedb", "cjjc", "ffhjbhahegji", "bihddjfdbhhigcf", "djccffcfjfcdbedcj",
                "jcfbhifieihfibgbbe", "jdbgiebfgch", "hgfgaibcabf", "idbaiaeadficihfd", "hihjaadeebegcbddi",
                "cdhahbjgjaifideb", "ecficjfgc", "dehjdf", "fffe", "ffeghcihcfab", "ahdbee", "gfccgc", "ahbffbiah",
                "ccg", "ecicgiddgebfgcdgi", "bc", "dbhggffhdbjhhab", "idjiijfgi", "afch", "hcghdedadhhchhjafcji",
                "eaigidgj", "bbgb", "bghibhjaahcebgf", "fjjffj", "deaaaaeeheaecj", "icjjcdijghgcg", "chjh",
                "jgcaahhbdjadfgjcg", "gfafjdgh", "fdggghejhh", "hahhjfidghfbcfjgji", "ejg", "bjachejdcfjc",
                "ibbbcgdbj", "hjjhccggidaie", "iiaehchic", "jgheggigbbfa", "afgieeeafaiaiccaag", "eejjfbihhiegbbbgfeh",
                "fjdbcaijfjc", "igeedcfegceaajbe", "aafjhaeahbedcf", "agbcbeifeahh", "fafjajddaabefcjdcff",
                "aajfahafedejifaga", "hbag", "ca", "bffdfecaebaghccfbdej", "id", "cdbbihchhebfi", "cjaihigib",
                "bfahhjjjabdeeeje", "bhcagbgc", "ejjfhebejadiidehdcgb", "ecigdhfifbjch", "jgagf", "bhjdaejfbgjc",
                "hbjfiediiajbej", "cjgd", "acejgdhecef", "jhjdbi", "ijidbeaaheaiahjcfcd", "gjdfjgcechcjc",
                "bfidjacdhegegibhh", "egbefbdbicbid", "biga", "igebachebcjcecge", "dbfciciahgfebecb", "ffaig",
                "ebcdeaciibfjefb", "hcaibiidejh", "hbfebahiid", "ffgehig", "dfcgidibacf", "efdjbchgaihf", "abjjhfcah",
                "ijjbeibhedhi" };
        StringUtils stringUtils = new StringUtils();
        final List<List<Integer>> result = stringUtils.palindromePairs(words);
        result.stream().forEach(resultList -> {
            resultList.stream().forEach(index -> System.out.print(" " + index));
        });
    }
}
