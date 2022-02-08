package OARelated.U;

public class SigOps {
    public SigOps() {
        String[] ops = {
                "TYPE Code", "TYPE Signal", "MOVE_CURSOR -3", "SELECT 5 8", "TYPE ou", "UNDO", "TYPE nio"
        };

        System.out.println(solution(ops));
    }

    String solution(String[] operations) {
        // filter out undo ops
        StringBuffer sb = new StringBuffer();
        filterOps(operations);

        int cursorPos = 0;
        String prevOp = "";
        for (String op: operations) {
            if (op.contains("IGNORE")) {
                prevOp = "IGNORE";
                continue;
            }
            else {
                String[] pieces = op.split(" ");
                String cmd = pieces[0];
                if (cmd.equals("TYPE")) {
                    // we'd do insert
                    if (prevOp.contains("SELECT")) {
                        String[] prevC = prevOp.split(" ");
                        int start = Integer.parseInt(prevC[1]);
                        int end = Integer.parseInt(prevC[2]);
                        String nsb = sb.substring(0, start) + sb.substring(end, sb.length());
                        // update sb?
                        sb = new StringBuffer(sb);

                    }  else {
                        String text = op.split(" ")[1];
                        sb.append(text);
                        cursorPos += text.length();
                    }
                }
                else if (cmd.equals("MOVE_CURSOR")) {
                    int offset = Integer.parseInt(pieces[1]);
                    cursorPos += offset;
                    // make sure only the end
                    cursorPos = Math.min(sb.length(), cursorPos);
                    // also the min is 0 the start
                    cursorPos = Math.max(cursorPos, 0);
                }

                // update prevCmd
                prevOp = op;
            }
        }

        return sb.toString();

    }

    void filterOps(String[] ops) {
        for (int i = 1; i < ops.length; i++) {
            if (ops[i].equals("UNDO") && (
                    ops[i-1].contains("TYPE")
                            ||
                            ops[i-1].contains("MOVE_CURSOR"))) {
                // modify so you'd do no ops
                ops[i] = "IGNORE";
                ops[i-1] = "IGNORE";
            }
        }
    }

}
