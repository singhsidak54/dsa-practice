package Scaler.DesignPatterns.Facade.Data;

import Scaler.DesignPatterns.Facade.Data.models.AnalysisAlgorithmConfig;
import Scaler.DesignPatterns.Facade.Data.models.AnalysisResult;
import Scaler.DesignPatterns.Facade.Data.models.DataCollectionParams;
import Scaler.DesignPatterns.Facade.Data.models.PreprocessingOptions;
import Scaler.DesignPatterns.Facade.Data.services.AnalysisAlgorithmService;
import Scaler.DesignPatterns.Facade.Data.services.DataCollectionService;
import Scaler.DesignPatterns.Facade.Data.services.DataPreprocessingService;
import Scaler.DesignPatterns.Facade.Data.services.VisualizationService;

public class DataAnalysisManager {

    private final DataAnalysisFacade dataAnalysisFacade;

    public DataAnalysisManager(DataCollectionService dataCollectionService,
                               DataPreprocessingService dataPreprocessingService,
                               AnalysisAlgorithmService analysisAlgorithmService,
                               VisualizationService visualizationService) {
        this.dataAnalysisFacade = new DataAnalysisFacade(dataCollectionService, dataPreprocessingService, analysisAlgorithmService, visualizationService);
    }

    public AnalysisResult performFullAnalysis(DataCollectionParams collectionParams,
                                              PreprocessingOptions preprocessingOptions,
                                              AnalysisAlgorithmConfig algorithmConfig) {
        return this.dataAnalysisFacade.performFullAnalysis(collectionParams, preprocessingOptions, algorithmConfig);
    }
}

