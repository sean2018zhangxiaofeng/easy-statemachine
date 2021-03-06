package ambitor.easy.statemachine.sf.action;

import ambitor.easy.statemachine.core.action.Action;
import ambitor.easy.statemachine.core.context.StateContext;
import ambitor.easy.statemachine.sf.enumerate.GrantEvent;
import ambitor.easy.statemachine.sf.enumerate.GrantState;
import ambitor.easy.statemachine.workflow.action.WorkFlowAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static ambitor.easy.statemachine.sf.enumerate.GrantConstant.DOCUMENT_CREDIT_STATUS;
import static ambitor.easy.statemachine.sf.enumerate.GrantConstant.DOCUMENT_CREDIT_SUCCESS;

@Slf4j
@Component
public class DocumentCreditAction implements WorkFlowAction<GrantState, GrantEvent> {

    @Override
    public void execute(StateContext<GrantState, GrantEvent> context) {
        log.info("建档授信");
        addHeader(context,DOCUMENT_CREDIT_STATUS,DOCUMENT_CREDIT_SUCCESS);
    }

    public Action<GrantState, GrantEvent> errorAction() {
        return (s) -> log.info("建档授信异常，最后一次尝试");
    }
}
