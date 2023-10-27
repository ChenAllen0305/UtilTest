package Compare;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeCompare {
    public static void main(String[] args) {
        String code = "619071";
        String reqCode = "619071";
        if (code == null || !code.equalsIgnoreCase(reqCode)) {
            log.info("doFilterInternal1");
        }
    }
}
