import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * 统一异常处理+日期转换
 * @author zfh
 * @version 1.0
 * @since 2019/3/25 16:03
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        GenericConversionService genericConversionService = (GenericConversionService) binder.getConversionService();
        if (genericConversionService != null) {
            genericConversionService.addConverter(new DateConverter());
        }
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public JsonResult handler(Exception e) {
        logger.error("统一异常处理", e);
        return new JsonResult(false, "程序异常", e.toString());
    }
}
