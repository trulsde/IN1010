class TestMedaljer {
    public static void main(String[] args) {
        Deltagerland danmark = new Deltagerland("Danmark", 0, 0, 0),
                     finland = new Deltagerland("Finland", 1, 1, 4),
                     island = new Deltagerland("Island", 0, 0, 0),
                     norge = new Deltagerland("Norge", 14, 14, 11),
                     sverige = new Deltagerland("Sverige", 7, 6, 1);
        System.out.println("Finland vs Sverige: " + finland.compareTo(sverige));
        System.out.println("Norge vs Sverige: " + norge.compareTo(sverige));
        System.out.println("Danmark vs Sverige: " + danmark.compareTo(sverige));
        System.out.println("Danmark vs Island: " + danmark.compareTo(island));
        }
    }
    